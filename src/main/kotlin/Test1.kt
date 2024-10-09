object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val obj = Any()
        try {
            (obj as Object).wait()
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }

    }
}
