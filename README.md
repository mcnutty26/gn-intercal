# gn-intercal
Intercal program to print the Oxford University Computing Society logo

### Output:  
```
OXOX  
XXXO  
OXOO  
OXXO
```

### How printing in INTERCAL works
Intercal processes input on a cyclical tape that has one cell representing each of the 256 extended ASCII characters. The tape head begins at zero when the program starts, and can only move left. 

This is relevant because output characters can be thought of occupying the reverse of this tape. That is to say that that the output head (which is thankfully seperate from the input head) can only move to the left in descending order of charcter codes (so from Z back to A). The task of printing characters thus becomes the task of describing the movements of the output head along the tape.

This isn't too bad until you realise that because the output head moves from right to left, it reads the binary of the characters it encounters from most significant bit to least significant bit. If the head is moved to position 108, presumably because the user was attempting to print an 'l', the output head will read the binary representation of 'l' backwards. In this way 0110 1100 becomes 0011 0110, which is in fact '6'. As you might imagine, this quickly becomes confusing! Printing subsequent characters will need to take into account that the head is now starting from an offset of 108 instead of 0.

### Annotated snippets
TODO

`DO ,1 <- #20`

`PLEASE DO ,1 SUB #1 <- #14`

`DO ,1 SUB #2 <- #216`

`DO ,1 SUB #3 <- #40`

`DO ,1 SUB #4 <- #216`

`PLEASE READ OUT ,1`

`PLEASE GIVE UP`
