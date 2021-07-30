package app.spood.common

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}