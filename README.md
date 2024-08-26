# Trek Trading App

_A secure and scalable cryptocurrency trading platform built with React, Spring Boot, MySQL, TailwindCSS, Redux, Axios, Stripe, Razorpay, and CoinGecko API._

## Overview

Trek Trading App is a cryptocurrency trading platform designed to offer users a seamless experience in buying, selling, and managing various cryptocurrencies. The platform features a responsive frontend powered by React and TailwindCSS, while the backend is built with Spring Boot and MySQL for robust data management. It integrates popular payment gateways like Stripe and Razorpay for secure transactions, and includes advanced wallet functionality and two-factor authentication for enhanced security.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Scalable Trading Platform:** Architected a secure and scalable platform with integrated buy/sell functionality, allowing seamless cryptocurrency transactions.
- **Responsive Frontend:** Developed a user-friendly and responsive interface using React and TailwindCSS for a smooth user experience.
- **Robust Backend:** Implemented a backend using Spring Boot and MySQL for secure data handling and transaction management.
- **Advanced Wallet Functionality:** Built features supporting wallet-to-wallet transfers, bank withdrawals, and balance top-ups for efficient fund management.
- **Payment Gateway Integration:** Integrated Stripe and Razorpay for real-time transactions, ensuring smooth and secure payments.
- **Enhanced Security:** Implemented two-factor authentication to enhance the security of user accounts and transactions.

## Installation

1. **Clone the repo:**

```bash
git clone https://github.com/lequyan2003/crypto-trading-app.git
```

2. **Navigate to the backend directory**

```bash
cd crypto-trading-app/server
```

3. **Install server dependencies**

```bash
mvn clean install
```

4. **Run the Spring Boot backend**

```bash
mvn spring-boot:run
```

5. **Navigate to the frontend directory:**

```bash
cd ../client
```

6. **Install client dependencies**

```bash
npm install
```

7. **Run the React frontend**

```bash
npm run dev
```

## Usage

After starting both the backend and frontend, access the application through your browser by navigating to the local server URL.

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repo.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
