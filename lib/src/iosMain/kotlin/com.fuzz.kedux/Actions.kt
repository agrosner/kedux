package com.fuzz.kedux

/**
 * Description:
 */

class ActionCreate<T : Any, A : Any, P : Any>(
        private val ofType: T,
        private val payloadCreator: (arguments: A) -> P) {

    fun create(arguments: A): Action<T, P> = object : Action<T, P> {
        override val type: T = ofType
        override val payload: P = payloadCreator(arguments)
    }
}

class SingleAction<T : Any>(override val type: T) : Action<T, Unit> {
    override val payload: Unit = Unit
}