package studio.forface.recruiteetodoist.domain

interface Invokable

inline operator fun <T : Invokable, V> T.invoke(block: T.() -> V): V =
    block()
