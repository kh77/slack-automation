import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.methods.SlackApiException;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import java.io.IOException;

import static com.github.seratch.jslack.api.model.block.Blocks.*;
import static com.github.seratch.jslack.api.model.block.composition.BlockCompositions.markdownText;
import static com.github.seratch.jslack.api.model.block.composition.BlockCompositions.plainText;
import static com.github.seratch.jslack.api.model.block.element.BlockElements.asElements;
import static com.github.seratch.jslack.api.model.block.element.BlockElements.button;
import static com.github.seratch.jslack.api.webhook.WebhookPayloads.payload;


public class Automation {

    public static void main(String[] args) throws IOException, SlackApiException {
        String text = ":wave: Hello Java folks!";

        Slack slack = Slack.getInstance();
        String webhookUrl = "https://hooks.slack.com/services/T11111/B1111/o2222222";

        sendMessage(text, slack, webhookUrl);
        sendSelectionMessage(slack, webhookUrl);
    }

    private static void sendSelectionMessage(Slack slack, String webhookUrl) throws IOException {
        WebhookResponse response = slack.send(webhookUrl, payload(p -> p
                .text("Quiz.")
                .blocks(asBlocks(
                        section(section -> section.text(markdownText("*Please select your favourite language?"))),
                        divider(),
                        actions(actions -> actions
                                .elements(asElements(
                                        button(b -> b.text(plainText(pt -> pt.emoji(true).text("Java"))).value("v1")),
                                        button(b -> b.text(plainText(pt -> pt.emoji(true).text("Go"))).value("v2")),
                                        button(b -> b.text(plainText(pt -> pt.emoji(true).text("C#"))).value("v3"))
                                ))
                        )
                ))
        ));
        System.out.println(response);
    }

    private static void sendMessage(String text, Slack slack, String webhookUrl) throws IOException {
        Payload payloads = Payload.builder().text(text).build();

        WebhookResponse response = slack.send(webhookUrl, payloads);
        System.out.println(response);
    }
}
