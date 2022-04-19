# Wifi_Secure_Chat
RSA &amp; SHA &amp; P2P

==========

It's a simple quick project which supports wifi chatting and messaging
the project is pure Java.
Cuz it's a fun and testing project I do NOT use SOLID and hard patterns
it is as quick as I can just test a project
<< Don't Use in product Project>>

---------------------------------------------------
scenario :
One or many Servers on Wifi
each Server has 0 or many clients

Just Text messages allowed

messaging is encrypted by the RSA algorithm
Message Text is encrypted by the above algorithm and that's why we can send small messages (less than 130 characters)
each Mac address has its own Private key and Public key
At the start of communication clients and sever send their PublicKey
each message encrypt by destination PublicKey and decrypted by receiver PrivateKey (to Authorize the receiver)
The server sends messages to the last joined clint (it was better to choose receiver but I will extend this later )
the message itself hashed by SHA-256 algorithm and sent with an encrypted message to the receiver
receiver decrypts the message and check the hash to modify it is the same message and the message has not changed


---------------------------------------------------------

Copyright :
It's a personal project for a computer science student,
I will make this repository public after he grants me the permission
Mostafa Imani
