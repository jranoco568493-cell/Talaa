# Talaan Loan Ledger

Talaan is a frontend demo for recording loans, tracking payments, and checking which borrowers are due today or overdue. It uses fictional sample data and saves changes in the browser.

## Try the demo

Open the live demo and sign in with username `lender` and password `demo123` to explore the sample ledger. Choose **Sign up** to start with an empty demo ledger. Use fictional borrower details and a made-up password. [Open the Talaan demo](https://talaan-loan-ledger-demo.awakebramble2.chatgpt.site)

- **Dashboard** shows lending totals and the Due Today and Overdue queues.
- **Borrowers and Payments** let you add or edit borrowers, record partial or advance payments, and view payment history.
- **Archive** keeps loans in the ledger totals and lets you restore a borrower. **Delete** removes a borrower with no recorded payments after you confirm.
- **Settings** lets you switch themes, choose the default borrower sort order, and log out.

The demo uses November 19, 2026 as its fixed reference date for payment schedules and overdue statuses.

## Run locally in VS Code

Open the Talaan project folder in VS Code. With the Live Server extension installed, right-click `dist/index.html` in Explorer and choose **Open with Live Server**. [Live Server instructions](https://github.com/ritwickdey/vscode-live-server)

With Python 3 installed, run the following command from the project root in the VS Code terminal.

```sh
python -m http.server 4173 --bind 127.0.0.1 --directory dist
```

Use `python3` if that is your Python command. Open [the local preview](http://127.0.0.1:4173/) in your browser and press `Ctrl+C` in the terminal when you finish. [Python HTTP server documentation](https://docs.python.org/3/library/http.server.html#command-line-interface)

## Browser data and backend handoff

The demo saves accounts and ledgers in IndexedDB and stores theme and sort preferences in local storage. Use the same browser profile and site address to reopen saved records. The local preview and live demo have separate records, and clearing site data erases the records saved for that address.

For the future private version, connect sign-in and ledger actions to an authenticated backend. That backend will check access, validate loan changes, and save real records in a shared database.

## Project layout

- `dist/index.html` and `dist/styles.css` define the page and its themes.
- `dist/app.mjs` handles screens, forms, and dialogs.
- `dist/ledger.mjs` handles loan calculations, sample data, and ledger actions.
- `dist/demo-auth.mjs` and `dist/demo-store.mjs` handle demo sign-in and browser storage.
- `.openai/hosting.json` configures hosting for the static demo.
