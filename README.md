# 📦 PGPX

PGPX is a desktop GUI application built with Java Swing, inspired by the **Kleopatra** interface. It provides a friendly way to manage OpenPGP keys, encrypt and decrypt files, and perform common PGP operations.

---

## 🧑‍💻 Author

**Created by:** Taruna Wahyudi  
**Donate:** [https://your-donation-link.com](https://your-donation-link.com) *(replace with your real donation link)*

---

## 📋 Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [UI Overview](#ui-overview)
- [Contributing](#contributing)
- [License](#license)

---

## ✨ Features

- 🔐 Generate PGP key pairs (configurable algorithms, armor option, storage location)
- 📤 Encrypt files with recipient's email (and sender for signature)
- 📥 Decrypt encrypted files (with signature verification and passphrase)
- 📁 Import / Export keys
- 📑 Certificate detail viewer
- 🖥️ Clean and modern UI inspired by Kleopatra
- ✅ Field validation and error handling
- 🧭 Toolbar with core actions (Encrypt, Decrypt, Generate Key)
- 🧵 Modal dialogs for each operation with clean 1-column layout

---

## 🛠 Technologies Used

- Java 17+
- Swing (Java Desktop GUI)
- IntelliJ IDEA (recommended IDE)
- Bouncy Castle (for future cryptographic operations)

---

## 📂 Project Structure

```text
PGPX/
├── src/
│   └── org/example/
│       ├── PGPApp.java            // Main application window
│       ├── EncryptDialog.java     // Encrypt form dialog
│       ├── DecryptDialog.java     // Decrypt form dialog
│       ├── GenerateKeyDialog.java // Key generation dialog
│       └── utils/                 // Future utility or PGP logic
├── assets/                        // Icons, key samples, etc.
└── README.md                      // This documentation
```

---

## 🚀 Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/pgpx.git
   cd pgpx
   ```

2. Open the project in **IntelliJ IDEA**

3. Build & Run the `PGPApp.java` file

4. Optionally, include the **Bouncy Castle** library:
    - Download from [https://www.bouncycastle.org/latest_releases.html](https://www.bouncycastle.org/latest_releases.html)
    - Add the `.jar` to your project libraries

---

## ▶️ Usage

1. **Launch the app**
2. Use the top menu or toolbar:
    - `Certificates` → Import, Export, or view details
    - `Encrypt` → Select file, recipient, sender, armor option
    - `Decrypt` → Select encrypted file, your email, passphrase, verify signature
    - `Generate Key` → Choose algorithm, enter user details, armor preference
3. View all certificates (public/private keys) in the table

---

## 🖼 UI Overview

- The main window includes:
    - 📋 A non-editable table of certificates
    - 🔧 Toolbar with `Encrypt`, `Decrypt`, and `Generate Key`
    - 📁 Menu bar:
        - `Certificates` → Import, Export, Details
        - `View` → View Standard
        - `Tools` → (future)
        - `Help` → (future)
- Modal dialogs feature:
    - Clean, one-column layout
    - Labels above input fields
    - File chooser for file inputs
    - Checkbox toggles (e.g. `Armor`)
    - Responsive layout for various screen sizes

---

## 🧑‍🤝‍🧑 Contributing

1. Fork this repo
2. Create a new branch (`git checkout -b feature/awesome`)
3. Commit your changes (`git commit -am 'Add awesome feature'`)
4. Push to the branch (`git push origin feature/awesome`)
5. Create a new Pull Request

---

## 📜 License

This project is licensed under the **MIT License**.

Feel free to use, distribute, and modify as needed.

---

## 💖 Support

If you find this project helpful or want to support its development, feel free to:

> ☕ [Buy me a coffee](https://your-donation-link.com)

---
