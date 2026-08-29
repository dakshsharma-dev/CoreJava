Functions vs Methods

* Function: Independent block of code that can exist outside a class (C++, C, etc.).  
* Method: A function that is associated with an object or class.  
* In Java, all functions are methods because everything is inside a class.  
* In C++, both standalone functions and class methods exist.  


JDK vs JRE vs JVM

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