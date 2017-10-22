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
1. `DO ,1 <- #20` Each line of INTERCAL must start with either `PLEASE`, `DO`, or `PLEASE DO`. These can be used interchangably in order to improve program aesthetics. It is worth noting that a program which is too impolite will not compile. This line allocates the array that we are going to use to hold the program output, and assigns it a length of 20. 

2. `PLEASE DO ,1 SUB #1 <- #14` Set the first subindex (`SUB`) of the array to 14. This represents a shift of 14 places to the left of the zero starting index of the output tape, which is ASCII character 242 (256-14), which is 1111 0010 (‗). This is read as 0100 1111, which is character 79, which is the 'O' that we want. Be careful not to use `PLEASE` too liberally, as the compiler will refuse to compile any overly polite programs as it gets suspicious.

3. `DO ,1 SUB #2 <- #216` The next character of the output needs to be X, which is charcter 0101 1000 (88). This means we need to move to character 0001 1010 (26), which is the substitute character (`␚`). Because the output head is already at character 242 the offset we need is thus 242-26 which is 216 (remember that we can only move the head to the left).

...

4. `PLEASE READ OUT ,1` Next we have the program read out the contents of the array by making the output head follow the pattern we stored in the array.

5. `PLEASE GIVE UP` Then the program gives up. At this point, I suggest you do too.
