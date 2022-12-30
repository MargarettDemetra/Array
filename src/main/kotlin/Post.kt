data class Post(
    val id: Int,
    val ownerId: Int,
    val date: Int,
    val commentsCount: Int,
    val likesCount: Int,
    val text: String,
    val canCloseComment: Boolean,
    val canOpenComment: Boolean,
    val canLikes: Boolean,
    val canPublished: Boolean
)

object WallService {
    private var posts = emptyArray<Post>()
    fun add(post: Post): Post {
        posts += post
        return posts.last()


    }
}

fun main() {
    val post = Post(12, 122, 15, 1, 2, "Happy New Year", true, false, false, false)
    print(post.text)

}