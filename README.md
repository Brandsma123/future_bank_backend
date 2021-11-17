# Future_Bank

This project is a study case of developing REST API using Spring Boot. there is an account, merchant, transaction and wallet. account is a parent because we can do anything with account, Merchant is a thing where we can buy anything in a merchant, wallet is show you how many balance do you have and the transaction is used to pay merchant, withdraw and top up wallet. 

## Getting Started

### Prerequisites

* Oracle JDK 1.8.
* Maven
* PostgreSQL

### Dependencies
* Spring Web
* Spring Data JPA
* PostgreSQL Driver
* Spring Boot DevTools
* Spring Security

### Installing

* Using the package manager maven to install and build Future_Bank
```
mvn clean install
```

* running apps
```
java -jar target/Future_Bank-0.0.1-SNAPSHOT.jar
```

### Executing program
In here, you can do access with using API
### API
## 1. Account

#### a. Register Account
the first, you have to create your account.
```
localhost:8085/register
```
Request body:
```
{
    "fullName":"siska",
    "email":"sis@gmail.com",
    "phoneNumber":"94353489623",
    "address":"Banten",
    "motherName":"eni",
    "noAccount":"53844566454",
    "password":"siska",
    "userName":"siska123"    
}
```
you can create account more than one, but you have notice that email, phoneNumber, noAccount and username is unique 

#### b. Login
After the account is registered you have to do sign for the first time before you do a transaction.
```
localhost:8085/signin
```
Request body:
```
{
    "userName":"lila",
    "password":"lila"
}
```
After you do sign, you will find a token,

```
eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjpbeyJhdXRob3JpdHkiOiJBRE1JTiJ9XSwic3ViIjoibGlsYSIsImlhdCI6MTYzNzExMzI2MywiZXhwIjoxNjM3MTE2MjYzfQ.U6qwAu9WY-kxDezr36E3LB75n0bEa1xzRcnQtd45boC83LfNsa5h1mmeb3QSk2RX37KilGDmXC9JYFQ-adZ3Ow
```
Token is used to borrow you around the Future_Bank

#### c. Getting all account
You can find all account which are registered
```
localhost:8085/allAccount
```
#### d. update account
Updating is done when your id account is true
```
{
    "id":"bac3de5febba433b949a83aa25a99acd",
    "fullName":"saskia",
    "email":"sis@gmail.com",
    "phoneNumber":"94353489623",
    "address":"Banten",
    "motherName":"eni",
    "noAccount":"53844566454",
    "password":"siska",
    "userName":"siska123"
}
```

#### e. Delete account
account can be deleted with by id
```
localhost:8085/account?id=7ab051dcd12f437eb6a6d519f361bf74
```
## 2. Merchant
In here, Merchant is like a thing which will you buy 
#### a. Create Merchant
You can create Merchant
```
localhost:8085/merchant
```
RequestBody:
```
{
    "fullName": "brandsma",
    "price": 10000
}
```
#### b. Get all merchant
You can find all merchants
```
localhost:8085/merchants
```

#### c. Update merchant
Merchant can be updated
```
localhost:8085/merchant
```
Request body:
```
{
    "id" : "0b6284cc30744fbb82370736af0927d1",
    "fullName":"brandsma",
    "price":10000
}
```
#### d. Delete merchant
Merchant can be deleted by id
```
localhost:8085/merchant?id=0b6284cc30744fbb82370736af0927d1
```

## 3. wallet
Wallet is used to pay anything. Wallet relate with account.
#### a. Create wallet
```
localhost:8085/wallet
```
Request body:
```
{
    "saldo":15343000,
    "accountId":"1f03eccd1d984709b270ec3b9ca89e0f"
}
```
#### b. Get all wallet
```
localhost:8085/wallets
```
#### c. Update wallet
```
localhost:8085/wallet
```
Request body:
```
{
    "id": "084ec2c3aa584d1dbd6e4c8355565bc7",
    "saldo":98732,
    "accountId":"8063ae63d5464d5ca4079b09d083e8b1"
}
```
#### d. Delete wallet
```
localhost:8085/wallet?id=bf5ab521ed694644898f77bd70fe6724
```
## 4. Transaction
You can do all transaction with 3 categories, there is payment, withdraw and you can do top up your wallet
#### a. Create transaction with payment
```
localhost:8085/transaction
```
Request body:
```
{
    "category":"Payment",
    "nominal": 100,
    "walletId":"084ec2c3aa584d1dbd6e4c8355565bc7",
    "merchantId":"2e106bf41e364460bd8891e209ac9977"
}
```
#### b. Create transaction with withdraw
```
localhost:8085/transaction
```
Request body:
```
{
    "category":"Withdraw",
    "nominal": 100,
    "walletId":"084ec2c3aa584d1dbd6e4c8355565bc7"

}
```
#### c. Create transaction with top up
```
localhost:8085/transaction
```
Request body
```
{
    "category":"top up",
    "nominal": 2000,
    "walletId":"084ec2c3aa584d1dbd6e4c8355565bc7"
}
```

## Support
Further information email me: brandsmasiringo123@gmail.com

## License
Apache Software Foudation


