package _05_OOP_Concepts;
/*
     ASSOCIATION:
     A general relationship between two objects where one object uses, knows about,
     or interacts with another object.
     Neither object owns the other's lifetime; both can exist independently.

     Example:
     A Teacher teaches a Student.
     Teacher and Student can exist independently.

     AGGREGATION:
     A weak "has-a" relationship and a special form of Association.
     One object contains/uses another object, but does NOT own its lifetime.
     The contained object can exist independently of the container.

     Example:
     A Department has Teachers.
     If the Department is removed, the Teacher objects can still exist
     and can belong to another Department.

     COMPOSITION:
     A strong "has-a" relationship and a stronger form of Aggregation.
     One object owns the contained object's lifetime.
     The contained object is considered a part of the container and
     does not meaningfully exist independently of it.

     Example:
     A House has Rooms.
     If the House is destroyed, its Rooms are also considered destroyed.

     KEY DIFFERENCE:
     Association  -> General relationship; no ownership.
     Aggregation  -> Weak "has-a"; contained object can exist independently.
     Composition  -> Strong "has-a"; contained object's lifetime depends on container.

     In Java:
     These are design relationships, not Java keywords.
     They are generally represented using object references.

     Lifetime:
     Association  -> Both objects independent.
     Aggregation  -> Child can exist without parent.
     Composition  -> Child's existence depends on parent.
*/

public class _08_Relationships {
}
