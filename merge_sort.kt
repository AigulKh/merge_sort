
fun merge(A: MutableList<Int>, p: Int, q: Int, r: Int) {
    val arr = mutableListOf<Int>()
    for (i in p..q)
        arr.add(A[i])

    val arr_ = mutableListOf<Int>()
    for (i in q + 1..r)
        arr_.add(A[i])

    for (i in p..r)
        when {
            arr.isNotEmpty() && arr_.isNotEmpty() -> {
                if (arr.first() < arr_.first()) {
                    A[i] = arr.first()
                    arr.remove(arr.first())
                }
                else {
                    A[i] = arr_.first()
                    arr_.remove(arr_.first())
                }
            }
            arr.isEmpty() -> {
                A[i] = arr_.first()
                arr_.remove(arr_.first())
            }
            arr_.isEmpty() -> {
                A[i] = arr.first()
                arr.remove(arr.first())
            }
        }
}

fun sort(A: MutableList<Int>, p: Int, r: Int) {
    if (p < r) {
        val q = (p + r) / 2
        sort(A, p, q)
        sort(A, q + 1, r)
        merge(A, p, q, r)
    }
}

fun main() {
    val A = mutableListOf(5, 2, 4, 6, 1, 3, 2, 6)
    print("$A -> ")
    sort(A, 0, A.size - 1)
    println(A)
}