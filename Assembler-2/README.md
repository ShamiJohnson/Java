# enisar-CSCI30000-Assembler-
Assembler Implementation

First Pass Requirements:
  File Parser   - Nick
      - Delimit/Tokenize lines
      - Pass to Driver

  Mnemonic Code Hash  - Ben
      - Takes in mnemonic as String
      - Returns Key data type
        - Key = int Value, int Index
        - Getter methods Value() and Index()

  Location Counter  - S
      - Relative to START instruction for each Block
      - Initially consider program to be a single Block (main)
      - Non-Main Blocks relative to zero, create a Dependency Tree for each Label (only those for memory within the block)

  Symbol Table  - S
      - Linked List data type
        - String name, Tree value

  Dependency Tree   - Ben
      - Tree data structure, contains symbols as String.hashCode() and boolean
      - Left and Right children
      - Data = int, String.hashCode(), OR ('+','-','*', or '/')

  Gigantic Switch Statement   - Ben
      - Implement as a Method
      - Translate(String)
      
  Argument Processor      
      - Takes in String argument that is the argument of the mnemonic
      - Updates Symbol Table with new symbols
      - Determines Addressing Mode
      - Generates Dependency Tree involving symbols

  Intermediate File Writer   - Nick
      - Outputs lines from block sections
      - 4 Column Design, TAB Delimited
        1. Address
        2. Hash Key (int,int)
        3. Addressing Mode
        4. Dependency Tree (post-fix form)  ex: "ABC+*" would translate to A*(B+C)
        

Second Pass Requirements:
  Intermediate File Parser
      - Line by line parse, Tokenize by TAB
      - Pass to Driver
      - Solve Dependency Trees using Symbol Table

  Addressing Bits Generator
      - Takes in addressing mode
      - Returns String bits
  
  Binary Code Parser - Nick
      - Takes in string of 4 chars (0's and 1's)
      - Returns a hex letter (0 through F)
      
  Final File Writer - Nick
      - Writes hex values to a file
