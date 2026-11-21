import { applyLedgerAction, initialLedger } from "./ledger.mjs";

const databaseName = "talaan-demo";
const storeName = "ledger";
export const sampleLedgerKey = "current";

function openDatabase() {
  return new Promise((resolve, reject) => {
    let blocked = false;
    const request = indexedDB.open(databaseName, 1);
    request.onupgradeneeded = () => request.result.createObjectStore(storeName);
    request.onerror = () => reject(request.error);
    request.onblocked = () => {
      blocked = true;
      reject(new Error("The demo database is open in another tab."));
    };
    request.onsuccess = () => {
      const database = request.result;
      if (blocked) database.close();
      else resolve(database);
    };
  });
}

async function accessLedger(key, action) {
  const database = await openDatabase();
  try {
    return await new Promise((resolve, reject) => {
      const transaction = database.transaction(storeName, action ? "readwrite" : "readonly");
      const store = transaction.objectStore(storeName);
      let snapshot;
      let failure;

      transaction.oncomplete = () => resolve(snapshot);
      transaction.onabort = () => reject(failure ?? transaction.error ?? new Error("Storage operation stopped."));
      const read = store.get(key);
      read.onsuccess = () => {
        try {
          snapshot = read.result ?? initialLedger(key === sampleLedgerKey);
          if (action) store.put(applyLedgerAction(snapshot, action), key);
        } catch (error) {
          failure = error;
          transaction.abort();
        }
      };
    });
  } finally {
    database.close();
  }
}

export function loadLedger(key) {
  return accessLedger(key);
}

export function saveLedger(key, action) {
  return accessLedger(key, action);
}

async function accessAccount(mode, action) {
  const database = await openDatabase();
  try {
    return await new Promise((resolve, reject) => {
      const transaction = database.transaction(storeName, mode);
      const request = action(transaction.objectStore(storeName));
      transaction.oncomplete = () => resolve(request.result);
      transaction.onabort = () => reject(transaction.error ?? new Error("Account storage operation stopped."));
    });
  } finally {
    database.close();
  }
}

export function readAccount(username) {
  return accessAccount("readonly", store => store.get("account:" + username));
}

export function addAccount(username, account) {
  return accessAccount("readwrite", store => store.add(account, "account:" + username));
}
