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
    private var lastId = 0
    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }

    fun changePost(newPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
        if(post.id == newPost.id){
            posts[index] = newPost.copy()
            return true
        }
        }
        return false
    }

    fun printArray() {
        for (post in posts) {
            println(post.text)
        }
    }

}

fun main() {
    val post1 = Post(1, 122, 15, 1, 2, "Happy New Year", true, canOpenComment = true, false, false)
    WallService.add(post1)
    val post2 = Post(2,122,15,2,4,"Be careful",true,true,false,false)
    WallService.add(post2)
    WallService.printArray()
    println(WallService.changePost(Post(2,122,15,2,5,"Dont worry", true,true,false,false)))
    WallService.printArray()
}