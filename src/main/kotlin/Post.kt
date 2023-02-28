data class Post(
    val id: Int,
    val ownerId: Int,
    val date: Int,
    val commentsCount: Int,
    val likesCount: Int,
    val text: String?,
    val canCloseComment: Boolean,
    val canOpenComment: Boolean,
    val canLikes: Boolean,
    val canPublished: Boolean,
    val attachment: Array<Attachment> = emptyArray()
)

data class Comment(
    val id: Int,
    val date: Int,
    val text: String,
)

class PostNotFoundException(message: String) : RuntimeException(message)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var lastPostId = 0
    private var lastCommentId = 0


    fun add(post: Post): Post {
        posts += post.copy(id = ++lastPostId)
        return posts.last()
    }

    fun addComment(comment: Comment): Comment {
        comments += comment.copy(id = ++lastCommentId)
        return comments.last()

    }

    fun createComment(CommentId: Int, comment: Comment): String {
        for ((index, comments) in comments.withIndex()) {
            if (comment.id == CommentId) {
                return comment.text
            }

        }
        throw PostNotFoundException("Comment not exist")
    }


    fun changePost(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == newPost.id) {
                posts[index] = newPost.copy()
                return true
            }
        }
        return false
    }

    fun printArray() {
        for (post in posts) {
            println(post)
        }
    }

    fun printComment() {
        for (comment in comments) {
            println(comment)
        }
    }

    fun clear() {
        posts = emptyArray()
        var lastPostId = 0
    }

    fun clearComment(){
        comments = emptyArray()
        var lastCommentId = 0
    }


    fun main() {
        val post1 = Post(1, 122, 15, 1, 2, "Happy New Year", true, true, false, false)
        WallService.add(post1)
        WallService.add(post1)
        val post2 = Post(2, 122, 15, 2, 4, "Be careful", true, true, false, false)
        WallService.add(post2)
        WallService.printArray()
        println(WallService.changePost(Post(2, 122, 15, 2, 5, "Dont worry", true, true, false, false)))
        WallService.printArray()
        val comment1 = Comment(1, 23, "Arrr")
        WallService.addComment(comment1)
        WallService.addComment(comment1)
        WallService.createComment(2, comment1)
        WallService.printComment()
    }
}

