package semantic;

public enum MsilCommand {

    SUM("sum"),
    SUB("sub"),
    DIV("div"),
    MUL("mul"),
    PUSH_NUMBER("ldc.r8 %s"),
    PUSH_LOGICAL("ldc.i4.%s"),
    XOR("xor"),
    GREATER_THAN("cgt"),
    READ_VAR("ldloc %s"),
    LESS_THAN("clt"),
    EQUALS("ceq"),
    LOCALS(".locals(%s %s)"),
    SAVE_VAR("stloc %s"),
    READ_LINE("call string [mscorlib]System.Console::ReadLine()"),
    PARSE_STRING("call %s [mscorlib]System.%s::Parse(string)");

    MsilCommand(String code) {
        this.code = code;
    }

    private String code;

    public String get(Object... params) {
        return String.format(code);
    }
}
