**_Functions vs Methods_**

* Function: Independent block of code that can exist outside a class (C++, C, etc.).  
* Method: A function that is associated with an object or class.  
* In Java, all functions are methods because everything is inside a class.  
* In C++, both standalone functions and class methods exist.  


**_JDK vs JRE vs JVM_**

• JDK (Java Development Kit)
- Used for developing Java applications.
- Contains:
  • JRE
  • Compiler (javac)
  • Debugger, javadoc, and other development tools
- Can both develop and run Java programs.
- Platform-dependent (different builds for Windows, Linux, macOS).

• JRE (Java Runtime Environment)
- Used to run Java applications.
- Contains:
  • JVM
  • Core Java libraries
- Cannot compile Java source code.
- Platform-dependent (different builds for different OSes).

• JVM (Java Virtual Machine)
- Executes Java bytecode (.class files).
- Performs:
  • Bytecode execution
  • Memory management
  • Garbage collection
  • Runtime services
- JVM implementations are platform-dependent.

Compilation & Execution Flow  
JAVA Flow:  
MyProgram.java → javac → MyProgram.class (bytecode) → JVM → Machine
Code → CPU

C++ Flow:  
MyProgram.cpp → g++ → Machine Code (.exe) → CPU

Why Java is Platform Independent

• Java compiler (javac) produces bytecode, not machine code.  
• Bytecode is platform-independent.  
• Each OS has its own JVM implementation that translates bytecode into machine code.

Rule of Thumb

• If a compiler produces intermediate code (bytecode/IL) → potentially platform-independent.  
• If a compiler produces native machine code directly → platform-dependent.  


**_IMPORTANT NOTE_**:  
boolean size is JVM implementation-dependent; Java does not specify a fixed size.


**_TYPES OF DATATYPES:_**  
Primitive Data Types: Store simple values directly in memory.  
Non-Primitive (Reference) Data Types: Store MEMORY REFERENCES to objects.

**_Sort a map according to value NOT KEY in descending order(C++):_**

```cpp
map<int, int> mp = {
  {1, 40},
  {2, 10},
  {3, 30},
  {4, 20}
};  
vector<pair<int, int>> vec(mp.begin(), mp.end());

sort( vec.begin(), vec.end(), 
      [](const auto& a, const auto& b) {
         return a.second > b.second;   // decreasing order of value  
      });

for (auto& [key, value] : vec) {  
  cout << key << " " << value << '\n';
}
```


Explanation:  
* Third argument in sort function is custom comparator that tells sort() how to compare two elements.  
* `[](...) { ... }` -> This is a lambda function. Think of it as a function written directly where it is needed.  
* `[]` -> Part of lambda syntax. Empty `[]` means the function does not use any outside variables.  
* (const auto& a, const auto& b) -> The two elements that sort() wants to compare.  
* return a.second > b.second;  
* sort() asks: "Should a be placed before b?"  
true → Place a before b  
false → Do not place a before b