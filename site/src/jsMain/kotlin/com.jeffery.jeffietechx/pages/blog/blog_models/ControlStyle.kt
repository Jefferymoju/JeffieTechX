package com.jeffery.jeffietechx.pages.blog.blog_models

/**
 * Sealed class representing different styles for editor controls.
 */
sealed class ControlStyle(val style: String) {

    /**
     * Bold style.
     *
     * @property selectedText The text to be styled.
     */
    data class Bold(val selectedText: String?) : ControlStyle(
        style = "<strong>$selectedText</strong>"
    )

    /**
     * Italic style.
     *
     * @property selectedText The text to be styled.
     */
    data class Italic(val selectedText: String?) : ControlStyle(
        style = "<em>$selectedText</em>"
    )

    /**
     * Link style.
     *
     * @property selectedText The text to be styled.
     * @property href The URL of the link.
     * @property title The title of the link.
     */
    data class Link(
        val selectedText: String?,
        val href: String,
        val title: String
    ) : ControlStyle(
        style = "<a href=\"$href\" title=\"$title\">$selectedText</a>"
    )

    /**
     * Title style.
     *
     * @property selectedText The text to be styled.
     */
    data class Title(val selectedText: String?) : ControlStyle(
        style = "<h1><strong>$selectedText</strong></h1>"
    )

    /**
     * Subtitle style.
     *
     * @property selectedText The text to be styled.
     */
    data class Subtitle(val selectedText: String?) : ControlStyle(
        style = "<h3>$selectedText</h3>"
    )


    /**
     * Quote style.
     *
     * @property selectedText The text to be styled.
     */
    data class Quote(val selectedText: String?) : ControlStyle(
        style = "<div style=\"padding:12px;border-radius:6px;\"><em>❞ $selectedText</em></div>"
    )

    /**
     * Code style.
     *
     * @property selectedText The text to be styled.
     */
    data class Code(val selectedText: String?) : ControlStyle(
        style = "<div style=\"background-color:#0d1117;padding:12px;border-radius:6px;\"><pre><code class=\"language-kotlin\"> $selectedText </code></pre></div>"
    )

    /**
     * Image style.
     *
     * @property selectedText The text to be styled.
     * @property imageUrl The URL of the image.
     * @property desc The description of the image.
     */
    data class Image(
        val selectedText: String?,
        val imageUrl: String,
        val desc: String
    ) : ControlStyle(
        style = "<img src=\"$imageUrl\" alt=\"$desc\" style=\"max-width: 100%\">$selectedText</img>"
    )

    /**
     * Break style.
     *
     * @property selectedText The text to be styled.
     */
    data class Break(val selectedText: String?) : ControlStyle(
        style = "$selectedText<br>"
    )

    /**
     * Unordered list style.
     *
     * @property selectedText The text to be styled.
     */
    data class Ul(val selectedText: String?): ControlStyle(
        style = "<u>$selectedText</u>"
    )

    /**
     * SuperScript style.
     *
     * @property selectedText The text to be styled.
     */
    data class SuperScript(val selectedText: String?): ControlStyle(
        style = "<sup>$selectedText</sup>"
    )

    /**
     * SubScript style.
     *
     * @property selectedText The text to be styled.
     */
    data class SubScript(val selectedText: String?): ControlStyle(
        style = "<sub>$selectedText</sub>"
    )

    /**
     * StrikeThrough style.
     *
     * @property selectedText The text to be styled.
     */
    data class StrikeThrough(val selectedText: String?): ControlStyle(
        style = "<s>$selectedText</s>"
    )


    /**
     * UnorderedList style.
     *
     * @property selectedText The text to be styled.
     */
    data class UnorderedList(val selectedText: String?): ControlStyle(
        style = "<ul><li>$selectedText</li></ul>"
    )
}
