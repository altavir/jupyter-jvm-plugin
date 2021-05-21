import kotlinx.html.TagConsumer
import kotlinx.html.stream.createHTML
import org.jetbrains.kotlinx.jupyter.api.HTML
import org.jetbrains.kotlinx.jupyter.api.annotations.JupyterLibrary
import org.jetbrains.kotlinx.jupyter.api.libraries.JupyterIntegration

class HtmlContent(val builder: TagConsumer<*>.() -> Unit)

@JupyterLibrary
internal class ExampleJupyterIntegration : JupyterIntegration() {
    override fun Builder.onLoaded() {

        import<HtmlContent>()
        import("kotlinx.html.*")

        render<HtmlContent> { content ->
            HTML(createHTML().apply(content.builder).finalize())
        }
    }
}