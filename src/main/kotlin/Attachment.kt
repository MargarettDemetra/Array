import java.util.SplittableRandom

interface Attachment {
    val type: String
}
    class Audio(override val type: String,val duration: Int,val lyrics: String): Attachment {
    }

    class AudioAttachment(val audio: Audio) {
        val type = "audio"
    }

    class Note(override val type: String,val title: String) : Attachment {
    }

    class NoteAttachment(val note: Note) {
        val type = "note"
    }

    class Video(override val type: String,val platform: String,val duration: Int) : Attachment {
    }

    class VideoAttachment(val video: Video) {
        val type = "video"
    }

    class Document(override val type: String,val title: String,val wikiUrl: String) : Attachment {
    }

    class DocumentAttachment(val document: Document) {
        val type = "document"
    }

    class Photo(override val type: String,val height: Int,val weight: Int) : Attachment {
    }

    class PhotoAttachment(val photo: Photo) {
        val type = "photo"
    }








