import { createServer } from "node:http";
import { readFile } from "node:fs/promises";
import { extname } from "node:path";

const types = {
  ".html": "text/html; charset=utf-8",
  ".css": "text/css; charset=utf-8",
  ".mjs": "text/javascript; charset=utf-8",
  ".woff2": "font/woff2",
};

createServer(async (request, response) => {
  const { pathname } = new URL(request.url, "http://127.0.0.1");
  const file = pathname === "/" ? "index.html" : pathname.slice(1);
  if (!/^(?:fonts\/)?[a-z0-9_.-]+$/i.test(file) || !types[extname(file)]) {
    response.writeHead(404).end();
    return;
  }
  try {
    const body = await readFile(new URL("./talaan/dist/" + file, import.meta.url));
    response.writeHead(200, { "Content-Type": types[extname(file)], "Cache-Control": "no-store" }).end(body);
  } catch {
    response.writeHead(404).end();
  }
}).listen(Number(process.argv[2] ?? 4173), "127.0.0.1", function () {
  console.log("http://127.0.0.1:" + this.address().port);
});
