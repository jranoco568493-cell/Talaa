import { addAccount, readAccount, sampleLedgerKey } from "./demo-store.mjs";

const usernamePattern = /^[a-z0-9._-]{3,32}$/i;
const encoder = new TextEncoder();

export function usernameError(username) {
  if (!username) return "Required";
  if (!usernamePattern.test(username)) return "Use 3–32 letters, numbers, periods, underscores, or hyphens.";
  return "";
}

async function derivePassword(password, salt) {
  const key = await crypto.subtle.importKey("raw", encoder.encode(password), "PBKDF2", false, ["deriveBits"]);
  const hash = await crypto.subtle.deriveBits(
    { name: "PBKDF2", hash: "SHA-256", salt, iterations: 600_000 }, key, 256
  );
  return new Uint8Array(hash);
}

export async function authenticateDemo(username, password) {
  if (usernameError(username)) return null;
  username = username.toLowerCase();
  if (username === "lender") return password === "demo123" ? sampleLedgerKey : null;

  const account = await readAccount(username);
  if (!account) return null;
  const hash = await derivePassword(password, account.salt);
  const mismatch = hash.reduce((difference, byte, index) => difference | (byte ^ account.hash[index]), 0);
  return mismatch === 0 ? "account-ledger:" + username : null;
}

export async function registerDemo(username, password) {
  username = username.toLowerCase();
  if (username === "lender" || await readAccount(username)) return null;
  const salt = crypto.getRandomValues(new Uint8Array(16));
  const hash = await derivePassword(password, salt);
  try {
    await addAccount(username, { salt, hash });
  } catch (error) {
    if (error?.name === "ConstraintError") return null;
    throw error;
  }
  return "account-ledger:" + username;
}
