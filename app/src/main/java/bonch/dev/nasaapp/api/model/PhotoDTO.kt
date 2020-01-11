package bonch.dev.nasaapp.api.model

import bonch.dev.nasaapp.api.NasaService

class PhotoDTO {
    var identifier = ""
    var caption = ""
    var image = ""
    var date = ""

    fun getPhotoIdentifier(): String {
        return identifier
    }

    fun setPhotoIdentifier(identifier: String) {
        this.identifier = identifier
    }

    fun getPhotoCaption(): String {
        return caption
    }

    fun setPhotoCaption(captino: String) {
        this.caption = caption
    }

    fun getPhotoImage(): String {
        return caption
    }

    fun setPhotoImage(image: String) {
        this.image = image
    }

    fun getPhotoDate(): String {
        return caption
    }

    fun setPhotoDate(date: String) {
        this.date = date
    }

    fun getImageUrl(): String? { //https://api.nasa.gov/EPIC/archive/enhanced/2016/12/04/png/epic_RBG_20161204003633.png?api_key=DEMO_KEY
        val sb = StringBuilder()
        sb.append("https://api.nasa.gov/EPIC/archive/natural/")
        val dateComponents =
            date.split(" ").toTypedArray()[0].split("-").toTypedArray()
        sb
            .append(dateComponents[0]).append('/')
            .append(dateComponents[1]).append('/')
            .append(dateComponents[2]).append("/png/")
            .append(image).append(".png?api_key=").append("bUPDj3NcY7TPvoShGVEilLJJmiYHzdqyirJx04n4")
        return sb.toString()
    }
}