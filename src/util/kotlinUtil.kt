package util


//TODO Unit (documentation)이면 생략가능? => default 랑 type 추론
@Suppress("UNUSED_PARAMETER")
fun TODO(
    task: String,
    documentation: Unit = Unit,
    references: Function<Any?> = {}
): Nothing = throw NotImplementedException(task)

class NotImplementedException(message: String) : Exception(message)