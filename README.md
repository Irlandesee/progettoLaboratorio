#PROGETTO LABORATORIO 2021 - 2022



#NOTES:

#Aes algorithm:
	Iterativem symmetric-key block cypher that supports cryptographic keys (secret keys)
	of 128, 192, and 256 bits to encrypt and decrypt data in blocks of 128 bits.
	If the data to be encrypted does not meet the block size of 128 bits requirement, it must be padded.
#Aes variations
1. ECB - Electronic Code Book
2. CBC - Cypher Block Chaining
3. CFB - Cypher Feedback
4. OFB - Output Feedback
5. CTR - Counter
6. GCM - Galois/Counter Mode

#Ecb - electronic code book
Simplest operation mode of all. 
	The plaintext is divided into block with a size of 128 bits.
	Then each block will be encrypted with the same key and algorithm.
	Therefore, it produces the same result for the same block. --> Main weakness, not recommended.

#Cbc - Cypher Block Chaining
Cbc uses an IV - Initialization Vector to augment the encrypt. 
	First CBC uses the plaintext block xor with IV.
	Then it ecrypts the result to the ciphertext block.
	In the next block, it uses the encryption result to xor with the plaintext block until the last block.
In this mode, ecryption can not be parallelized, but decryption can be parallelized.
It also requires padding data.

#Cfb - Cypher feedback
This mode can be used as a stream cipher. 
	First, it encrypts the IV, 
	then it will xor with the plaintext block to get the ciphertext.
	Then CFB encrypts the encryption result to xor the plaintext. It needs and IV.
In this mode, decryption can be parallelized but encryption can not be parallelized.

#Ofb - Output feedback
This mode can be used as a stream cipher. 
	First, it encrypts the IV.
	Then it usses the encryption results to xor the plaintext to get ciphertext.
It doesn't require padding data and will not be affected by the noisy block.

#Ctr - counter
This mode uses the value of a counter as an IV. It's very similar to OFB, but it uses the counter to be encrypted every time instead of the IV.
It has two strengths, inclyding encryption/decryption parallelization, and noise in one block does not affect other blocks

#Gcm - Galois/Counter Mode
This mode is an extension of the CTR mode. The GCM has received significant attention and is recommended by NIST. The GCM model outputs ciphertext and an authentication tag. The main advantage of this mode is its efficiency.

#IV - Initialization vector
Iv or Starting Variable is an input to cryptographic primitive being used to provide the initial state. It is typically required to be random or pseudorandom, but sometimes an IV only need to be unpredictable or unique.




#HASHING
Hashing is the process of generating a string, or hash, from a given message using a mathematical function known as a cryptographic hash function.
While there are several hash functions out there, those tailored to hashing functions need to have 4 main properties to be secure:
1. It should be deterministic: the same message processed by the same hash function should always produce the same hash.
2. It's not reversible: It's impractical to generate a message from its hash
3. It has high entropy: a small change to a message should produce a vastly different hash
4. It resist collissions: two different messages should not produce the same hash 








































