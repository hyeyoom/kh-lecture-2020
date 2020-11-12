function countdown(startAt) {
    let s = startAt
    function decrement() {
        return s--
    }
    return decrement
}

a = countdown(10)
b = countdown(10)

console.log(a())
console.log(a())
console.log(a())
console.log(b())