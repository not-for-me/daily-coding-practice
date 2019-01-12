package io.notforme

/**
 * 요구사항: 이름을 입력 받아 이름을 이용하여 인사 말을 출력하는 프로그램
 * 제약조건:
 *  1) 입력 부분, 문자열 연결 부분, 출력 부분을 별도로 작성 => 완료
 * 추가 요구사항:
 *  1) 변수를 미사용 => 완료
 *  2) 사람들마다 서로 다른 인사말이 나타나도록 => 완료
 */
class HelloWorld {
    companion object {
        private val predefinedMessages = listOf(
                "Hello, %s, nice to meet you",
                "What's up %s!",
                "Good to see you, %s"
        )

        fun selectMessage(): String = predefinedMessages.shuffled().first()
    }

    fun run() {
        printPrompt()

        printHelloMsg()
    }

    private fun printHelloMsg() {
        println(selectMessage().format(readLine()))
    }

    private fun printPrompt() {
        print("What is your name? ")
    }
}

fun main(args: Array<String>) {
    println("Hello Kotlin")
    HelloWorld().run()
}