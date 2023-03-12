import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clear() {
        WallService.clear()
    }

    @Before
    fun clearComment() {
        WallService.clearComment()
    }

    @Test
    fun add() {
        val post = WallService.add(Post(1, 1, 5, 43, 24, "Hello", true, true, false, false))

        assert(post.id != 0)
    }

    @Test

    fun changePostTrue() {
        val service = WallService
        service.add(Post(1, 2, 22, 23, 13, "Good day", true, true, false, false))
        service.add(Post(2, 3, 23, 13, 15, "Bad day", true, true, false, false))
        val changePost = Post(2, 3, 23, 13, 15, "It's wrong!", true, true, false, false)
        val result = service.changePost(changePost)

        assertTrue(result)
    }


    @Test

    fun changePostFalse() {
        val service = WallService
        service.add(Post(1, 2, 22, 23, 13, "Good day", true, true, false, false))
        service.add(Post(2, 3, 23, 13, 15, "Bad day", true, true, false, false))
        val changePost = Post(54, 3, 23, 13, 15, "It's wrong!", true, true, false, false)
        val result = service.changePost(changePost)

        assertFalse(result)
    }

    @Test
    fun addComment() {
        val comment = WallService.addComment(Comment(2, 12, "Hello"))
        assert(comment.id != 0)
    }

    @Test
    fun createCommentHasId() {
        val serviceTest = WallService
        serviceTest.addComment(Comment(1, 23, "Oops"))
        val result = serviceTest.createComment(1, Comment(1, 23, "Oops"))
        assertEquals("Oops", result)
    }


    @Test(expected = PostNotFoundException::class)
    fun shouldThrow(){
        val serviceTest = WallService
        serviceTest.createComment(23, Comment(1, 22, "Hi!"))
    }
}



