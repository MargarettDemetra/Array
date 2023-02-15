import java.util.SplittableRandom

interface Attachment {
    val type: String
}
    class Audio(val type: String,val duration: Int,val lyrics: String) {
    }

    class AudioAttachment(val audio: Audio): Attachment {
        override val type = "audio"
    }

    class Note(val type: String,val title: String) {
    }

    class NoteAttachment(val note: Note): Attachment  {
        override val type = "note"
    }

    class Video(val type: String,val platform: String,val duration: Int) {
    }

    class VideoAttachment(val video: Video): Attachment  {
        override val type = "video"
    }

    class Document( val type: String,val title: String,val wikiUrl: String) {
    }

    class DocumentAttachment(val document: Document) : Attachment {
        override val  type = "document"
    }

    class Photo(val type: String,val height: Int,val weight: Int) {
    }

    class PhotoAttachment(val photo: Photo) : Attachment {
        override  val type = "photo"
    }








