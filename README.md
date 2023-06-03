Simple encryption/decryption methods. Permutation methods

Implementation of tabular permutation ciphers, such as simple permutation, single permutation and double permutation

1. Method of simple permutation

In coding by the method of simple permutation, the key is the size of the table. The message is recorded in the table one by one by column. After filling the table with the text of the message, the contents of the table are read line by line to form the cipher text. Also, for the convenience of reception, the ciphertext can be written in groups of five letters (in the case of transmitting a message using Morse code).

Naturally, the sender and receiver of the message must agree in advance on the common key in the form of a table size. It should be noted that combining the letters of the ciphertext into 5-letter groups is not included in the cipher key and is done for the convenience of recording meaningless text. When decrypting, the actions are performed in the reverse order: write the cipher test from left to right, from top to bottom in a table of the required size by lines and read the text in columns from top to bottom, from left to right.

IMPORTANT! A long text is divided into blocks, each of which is covered by its own encryption table. The last encryption table may have many unfilled cells, they are filled with blanks. Each block is processed separately.

2. Single permutation by key

This method differs from the previous one in that the columns of the table are rearranged by a keyword, a phrase, or a set of numbers as long as the length of the table.

The encryption algorithm includes the following steps.
- Step 1. Take an encryption table of a certain size (it can be an open value).
- Step 2. The letters of the open text are entered in the table in columns from top to bottom, from left to right.
- Step 3. Each column is numbered according to the value of the key
- Step 4. The columns of the table are sorted according to the serial number.
- Step 5. From the table, letters are read from left to right, from top to bottom, and a ciphertext is formed.

The decryption algorithm has the following steps.
- Step 1. Take a PC of a certain size (maybe with an open value).
- Step 2. The letters of the ciphertext are entered in the table in order from left to right, from top to bottom.
- Step 3. According to the value of the key elements, the columns are rearranged according to the following rule: the i-th column of the table moves to the position of the key element with the value i.
- Step 4. From the table, letters are read in columns from top to bottom, from left to right, and an open text is formed.

3. Double permutation by key

To ensure additional secrecy, it is possible to re-encrypt a message that has already been encrypted using the "single key permutation" method.

The encryption method, which rearranges the columns and lines in the required order in the encryption table, is called double permutation.

In the case of a double permutation of columns and rows of the permutation table, they are defined separately for columns and separately for rows using two keys. one - for columns, second - for lines.

The encryption algorithm has the following steps.
- Step 1. Take a PC of a certain size (may be open to value).
- Step 2. The letters of the open text are entered in the table in columns from top to bottom, from left to right.
- Step 3. Each column is numbered according to the value of the first key.
- Step 4. Each line is numbered according to the value of the second key.
- Step 5. The columns of the table are sorted according to the serial number.
- Step 6. The rows of the table are sorted according to the serial number.
- Step 7. From the table, letters are read from left to right, from top to bottom, and a ciphertext is formed.

The decryption algorithm has the following steps.
- Step 1. Take an encryption table of some size (it can be an open value).
- Step 2. The letters of the ciphertext are entered in the table from left to right, from top to bottom.
- Step 3. In accordance with the value of the elements of the key, the rows are rearranged according to the following rule: the i-th row of the table moves to the position held by the element of the second key with the value i
- Step 4. According to the value of the elements of the key, the columns are rearranged according to the following rule: the i-th column of the table moves to the position of the element of the first key with the value i
- Step 5. From the table, letters are read in columns from top to bottom, from left to right, and an open text is formed.