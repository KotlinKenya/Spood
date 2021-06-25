package app.spood

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}