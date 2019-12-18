package keyouxing.designpattern.chain;

import java.nio.ByteBuffer;
import java.util.function.Consumer;

public class StringParser extends AbstractMessageHandler<ByteBuffer, String> {
    private static final String DEFAULT_DELIMITER   = "\n";
    CharParser charParser = new CharParser();
    DelimiterParser delimiterParser;
    public StringParser() {
        this(DEFAULT_DELIMITER);
    }

    public StringParser(String delimiter) {
        this.delimiterParser = new DelimiterParser(delimiter);
        charParser.complete(delimiterParser::receive);
    }
    public static void main(String[] args) {
        StringParser parser = new StringParser();
        parser.complete(System.out::println);
        parser.receive(ByteBuffer.wrap("hello world1\nhello".getBytes()));
        parser.receive(ByteBuffer.wrap(" world2\n".getBytes()));
//        CharParser charParser = new CharParser();
//        DelimiterParser delimiterParser = new DelimiterParser();
//        delimiterParser.complete(System.out::println);
//        charParser.complete(delimiterParser::receive);
//        charParser.receive(ByteBuffer.wrap("hello world1\nhello".getBytes()));
//        charParser.receive(ByteBuffer.wrap(" world2\n".getBytes()));
    }

    @Override
    public StringParser complete(Consumer<String> action){
        super.complete(action);
        delimiterParser.complete(action);
        return this;
    }

    @Override
    void parse(ByteBuffer buffer) {
        charParser.receive(buffer);
    }
}
