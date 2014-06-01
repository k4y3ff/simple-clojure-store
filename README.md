# simple-clojure-store

A non-durable KV store with JSON REST-style interface for collections of integers.

The "store" is essentially `Map[Keyword, Vector[Int]]`.

## Usage

- To run the application, use `lein ring server-headless`.
  - `GET "/average"` will
    - Return the average of the averages of each vector in the store as `{"average": 2.5}`, for example, if the store is not empty.
    - Return `{"average": null}` if the store is empty.
  - `GET "/average/:key"` will return the average of the vector for the given `key`.
    - Return the average of the numbers contained in the vector associated with the given `key` as `{"average": 2.5}`, for example, if the `key` exists in the store.
    - Return `{"average": null}` if the store does not contain the given `key`.
  - `POST "/"` with `{"key": num}` will
    - Create a new vector containing the given `num` and associate it with the given `key`, if `key` does not already exist in the store.
    - Append the given `num` to the vector associated with the given `key`, if `key`, already exists in the store.

- To run the unit tests, use `lein test`.
- To run the test script, use `./test-script.sh`.

## Related

To get started, I used the [Compojure template](https://github.com/weavejester/compojure-template). You, too, can start a new Compojure project: `lein new compojure <project name>`!
