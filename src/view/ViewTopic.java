package view;

import controler.TopicController;
import model.Topic;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import java.util.List;
public class ViewTopic {
    private final TopicController topicController;

    public ViewTopic() {
        this.topicController = new TopicController();
    }

    public void view(List<Topic> list) {
        if(list!=null){
            CellStyle Style = new CellStyle(CellStyle.HorizontalAlign.center);
            Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            table.addCell("            Topic Information          ", Style, 4);
            table.addCell("       ID        ", Style);
            table.addCell("       Name      ", Style);
            table.addCell("    Description   ", Style);
            table.addCell("       Status        ", Style);
            list.forEach(
                    topic -> {
                        table.addCell(topic.getId() + "", Style);
                        table.addCell(topic.getName(), Style);
                        table.addCell(topic.getDescription(), Style);
                        table.addCell(topic.getStatus() + "", Style);
                    }
            );
            table.addCell("Total Records :" + list.size(), Style, 4);
            System.out.println(table.render());
        }
    }

    public void view(Topic topic) {
        if (topic != null) {
            CellStyle Style = new CellStyle(CellStyle.HorizontalAlign.center);
            Table table = new Table(4, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
            table.addCell("            Topic Information          ", Style, 4);
            table.addCell("       ID        ", Style);
            table.addCell("       Name      ", Style);
            table.addCell("    Description   ", Style);
            table.addCell("       Status        ", Style);
            table.addCell(topic.getId() + "", Style);
            table.addCell(topic.getName(), Style);
            table.addCell(topic.getDescription(), Style);
            table.addCell(topic.getStatus() + "", Style);
            table.addCell("Total Records : 1", Style, 4);
            System.out.println(table.render());
        }
    }
}
