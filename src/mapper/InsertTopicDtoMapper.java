package mapper;

import dto.InsertTopicDto;
import model.Topic;

import java.util.function.Function;

public class InsertTopicDtoMapper implements Function<InsertTopicDto, Topic> {
    @Override
    public Topic apply(InsertTopicDto insertTopicDto) {
        return new Topic(
                insertTopicDto.name(),
                insertTopicDto.des(),
                insertTopicDto.status()
        );
    }
}
