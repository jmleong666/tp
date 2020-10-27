package seedu.address.logic.parser.tag;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONTACT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.tag.EditCommand;

class EditCommandParserTest {

    public static final Index INDEX_FIRST_TAG = Index.fromOneBased(1);
    private static final String MINIONS = "minions";

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_validInput_returnsEditCommand() {
        EditCommand.EditTagDescriptor descriptor = new EditCommand.EditTagDescriptor();
        descriptor.setTagName(MINIONS);
        assertParseSuccess(parser, String.format("1 %s %s%s", PREFIX_CONTACT, PREFIX_TAG, MINIONS),
                new EditCommand(INDEX_FIRST_TAG, descriptor, true));
    }

    @Test
    public void parse_invalidIndex_throwsParseException() {
        assertParseFailure(parser, String.format("%d %s %s%s", -1, PREFIX_CONTACT, PREFIX_TAG, MINIONS),
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_missingModel_throwsParseException() {
        EditCommand.EditTagDescriptor descriptor = new EditCommand.EditTagDescriptor();
        descriptor.setTagName(MINIONS);
        assertParseFailure(parser, String.format("1 %s%s", PREFIX_TAG, MINIONS),
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE));
    }
}
