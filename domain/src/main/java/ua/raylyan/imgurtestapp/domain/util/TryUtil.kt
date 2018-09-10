package ua.raylyan.imgurtestapp.domain.util

fun <T> tryOrNull(unsafeBlock: () -> T): T? = try {
    unsafeBlock.invoke()
} catch (i: Throwable) {
    null
}