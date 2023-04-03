package view;

import controler.TopicController;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class ViewTopic {
    private final TopicController topicController;

    public ViewTopic() {
        this.topicController = new TopicController();
    }

    public  Table viewTopic(){
        CellStyle Style=new CellStyle(CellStyle.HorizontalAlign.center);
        Table table=new Table(4, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
        table.addCell("            Topic Information          ",Style,4);
        table.addCell("       ID        ",Style);
        table.addCell("       Name      ",Style);
        table.addCell("    Description   ",Style);
        table.addCell("       Status        ",Style);
        topicController.getAllTopic().forEach(
                topic -> {
                    table.addCell(topic.getId()+"",Style);
                    table.addCell(topic.getName(),Style);
                    table.addCell(topic.getDescription(),Style);
                    table.addCell(topic.getStatus()+"",Style);
                }
        );
        table.addCell("Total Record :"+topicController.getAllTopic().size(),Style,4);
        return table;
    }
    public  Table viewTopicByName(String name){
        CellStyle Style=new CellStyle(CellStyle.HorizontalAlign.center);
        Table table=new Table(4, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.ALL);
        table.addCell("            Topic Information          ",Style,4);
        table.addCell("       ID        ",Style);
        table.addCell("       Name      ",Style);
        table.addCell("    Description   ",Style);
        table.addCell("       Status        ",Style);
        topicController.getTopicByName(name).forEach(
                topic -> {
                    table.addCell(topic.getId()+"",Style);
                    table.addCell(topic.getName(),Style);
                    table.addCell(topic.getDescription(),Style);
                    table.addCell(topic.getStatus()+"",Style);
                }
        );
        table.addCell("Total Records :"+topicController.getTopicByName(name).size(),Style,4);
        return table;
    }
}
