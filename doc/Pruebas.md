| Class   | Method    | Scenario                                       | Input                               | Output | 
| ------- | --------- | ---------------------------------------------- | ----------------------------------- | ------ |
| FunSets | contains  | contains(x => true, 100)                       | FunSet: x => true, Elem: 100        | true   |
| FunSets | singleton | Singleton matched                              | FunSet: s, Elem: 1                  | true   |
| FunSets | singleton | Greater than singleton                         | FunSet: s, Elem: 2                  | false  |
| FunSets | singleton | Less than singleton                            | FunSet: s, Elem: 0                  | false  |
| FunSets | union     | Element from s1                                | FunSet: s1, FunSet: s2              | true   |
| FunSets | union     | Element from s2                                | FunSet: s1, FunSet: s2              | true   |
| FunSets | union     | Element outside                                | FunSet: s1, FunSet: s2              | false  |
| FunSets | intersect | Even but negative                              | FunSet: positive, FunSet: even      | false  |
| FunSets | intersect | Positive but odd                               | FunSet: positive, FunSet: even      | false  |
| FunSets | intersect | Even and positive                              | FunSet: positive, FunSet: even      | true   |
| FunSets | diff      | Positive and not even                          | FunSet: positive, FunSet: even      | true   |
| FunSets | diff      | Positive but even                              | FunSet: positive, FunSet: even      | false  |
| FunSets | diff      | Negative                                       | FunSet: positive, FunSet: even      | false  |
| FunSets | filter    | Positive but less than 10                      | FunSet: positive, FunSet: greater10 | false  |
| FunSets | filter    | Positive and greater than 10                   | FunSet: positive, FunSet: greater10 | true   |
| FunSets | filter    | Negative                                       | FunSet: positive, FunSet: greater10 | false  |
| FunSets | forall    | All positives are greater than 10              | FunSet: greater10, FunSet: positive | true   |
| FunSets | forall    | Not all greater than 10 are positive           | FunSet: positive, FunSet: greater10 | false  |
| FunSets | forall    | Not all even numbers are positive              | FunSet: even, FunSet: positive      | false  |
| FunSets | exists    | There is at least one positive greater than 10 | FunSet: positive, FunSet: greater10 | true   |
| FunSets | exists    | There is not any positive greater than 10      | FunSet: negative, FunSet: greater10 | false  |
| FunSets | exists    | There is at least one positive that is even    | FunSet: positive, FunSet: even      | true   |
| FunSets | map       | 1 is not a multiple of 3                       | FunSet: positive, f: x * 3          | false  |
| FunSets | map       | 2 is not a multiple of 3                       | FunSet: positive, f: x * 3          | false  |
| FunSets | map       | 3 is a multiple of 3                           | FunSet: positive, f: x * 3          | true   |
