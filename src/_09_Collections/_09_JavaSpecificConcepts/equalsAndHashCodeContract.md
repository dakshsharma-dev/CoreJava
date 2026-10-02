# `equals()` + `hashCode()` with Collections

## 1. Why does `equals()` exist?

`==` checks whether two references point to the **same object**.

```java
Student s1 = new Student(10, "Daksh");
Student s2 = new Student(10, "Daksh");

s1 == s2;        // false
```

Even though both objects contain the same data, they are two different objects.

`equals()` exists to define **logical equality**:

> When should two different objects be considered equal?

For example, we may decide that two `Student` objects are equal when their `id` is the same.

```java
@Override
public boolean equals(Object obj) {
    Student other = (Student) obj; // cast is required because we are overriding Object class's method which has Object as argument and we are comparing two Student Objects.  
    return this.id == other.id;
}
```

Now:

```java
s1.equals(s2);   // true
```

### Remember

```text
==       → Are they the same object?
equals() → Are they logically equal?
```

---

# 2. Why does `hashCode()` exist?

Hash-based collections such as:

```java
HashSet
HashMap
```

need a way to quickly determine the **bucket** associated with an object.  
// Bucket ≈ an index/slot in the hash-table data structure(not HashTable class) where entries with the corresponding hash are stored/grouped.

`hashCode()` provides an integer hash value that the collection uses for this purpose.

You already know the basic hashing idea:

```text
object
   ↓
hashCode()
   ↓
hash value
   ↓
bucket
```

Then, if multiple objects end up in the same bucket, `equals()` is used to determine whether they are actually equal.

### Remember

```text
hashCode() → helps locate the relevant bucket quickly
equals()   → determines actual logical equality
```

---

# 3. `equals()` vs `hashCode()`

They have different jobs.

| Method       | Purpose                                              |
| ------------ | ---------------------------------------------------- |
| `equals()`   | Defines logical equality                             |
| `hashCode()` | Produces a hash value used by hash-based collections |

Think:

```text
equals()
    ↓
"What does equal mean for my object?"

hashCode()
    ↓
"Which hash bucket should this object go towards?"
```

---

# 4. The `equals()` + `hashCode()` Contract

There is one **main rule** you must remember:

> If `a.equals(b)` is `true`, then `a.hashCode()` and `b.hashCode()` MUST be the same.

Example:

```text
a.equals(b)          → true

therefore:

a.hashCode()         → 50
b.hashCode()         → 50
```

### But the reverse is NOT required

If:

```text
a.hashCode() == b.hashCode()
```

it does NOT mean:

```text
a.equals(b) == true
```

because **hash collisions are possible**.

For example:

```text
Object A → hashCode 50
Object B → hashCode 50
```

They can still be different objects:

```text
A.equals(B) → false
```

### Therefore

```text
equals() == true
       ↓
hashCode() MUST be same


hashCode() == same
       ↓
equals() MAY be true or false
```

This is the contract.

---

# 5. Why must the contract exist?

Suppose:

```java
Student s1 = new Student(10, "Daksh");
Student s2 = new Student(10, "Daksh");
```

and:

```java
s1.equals(s2) == true
```

If their hash codes are different:

```text
s1 → hashCode 100 → Bucket 100

s2 → hashCode 500 → Bucket 500
```

When a `HashSet` looks for `s2`, it goes towards bucket 500.

`s1` is in bucket 100.

Therefore, the collection may never compare:

```java
s2.equals(s1)
```

So two objects that your `equals()` says are equal can incorrectly coexist in the `HashSet`.

The contract prevents this situation.

---

# 6. How `HashSet` uses both

Conceptually:

```text
Adding/searching an object
          ↓
     hashCode()
          ↓
    relevant bucket
          ↓
       equals()
          ↓
Are they actually equal?
```

So:

```text
hashCode() → helps find where to look
equals()   → decides whether it is the same object logically
```

### Example

```java
HashSet<Student> set = new HashSet<>();

set.add(s1);
set.add(s2);
```

If:

```text
s1.equals(s2) == true
```

and:

```text
s1.hashCode() == s2.hashCode()
```

then `HashSet` can correctly recognise `s2` as a duplicate.

Result:

```java
set.size();    // 1
```
Important Note: If Student.equals() considers two Students equal when their id is the same,
then two Students with the same id will be considered the same element
even if their name, age, marks, etc. are different & the other element won't be pushed into the HashSet.

---

# 7. What does "override" mean?

`equals()` and `hashCode()` are already defined in `Object`.

When we write our own implementation inside `Student`, we are **overriding** those inherited methods.

Example:

```java
@Override
public boolean equals(Object obj) {
    ...
}

@Override
public int hashCode() {
    ...
}
```

We are basically saying:

> "The default behaviour isn't what I want for `Student`; I want to define it myself."

---

# 8. Why override both?

Suppose our equality rule is:

```text
Two Students are equal if their id is equal.
```

Then:

```java
@Override
public boolean equals(Object obj) {
    Student other = (Student) obj;
    return this.id == other.id;
}
```

Since equality depends on `id`, the hash code should also be generated using `id`:

```java
@Override
public int hashCode() {
    return Integer.hashCode(id);
}
```

Therefore:

```text
equals()
    → based on id

hashCode()
    → based on id
```

This satisfies the contract.

Note:

    If equals() and hashCode() are not overridden, Student uses Object's default
    equality, which is based on object identity/reference.

    Therefore:
    - Same object added twice → considered equal → duplicate rejected.
    - Different objects with identical fields → considered different → both added.

    We override equals() + hashCode() when we want to define logical equality
    (e.g., Students with the same id are considered equal).


---

# 9. What if we override `equals()` but NOT `hashCode()`?

This is a common mistake.

Suppose:

```java
@Override
public boolean equals(Object obj) {
    Student other = (Student) obj;
    return this.id == other.id;
}
```

but we don't override `hashCode()`.

Then the inherited `Object.hashCode()` may give different hash codes to two logically equal objects.

So:

```text
equals()       → true

hashCode()     → different
```

This violates the contract.

As a result, `HashSet`/`HashMap` can behave incorrectly for these objects.

### Rule

> **If you override `equals()`, you should also override `hashCode()` consistently.**

---

# 10. Final mental model

```text
equals()
   ↓
Defines logical equality
   ↓
"When are these two objects considered the same?"

hashCode()
   ↓
Produces hash value
   ↓
Helps hash-based collections find the relevant bucket

Contract:
   ↓
If equals() == true
→ hashCode() MUST be the same

But:
   ↓
Same hashCode
≠
necessarily equal
because collisions can happen.
```

## One-line revision

> **`equals()` defines equality, `hashCode()` supports efficient hashing, and the contract guarantees that logically equal objects get the same hash code.**
