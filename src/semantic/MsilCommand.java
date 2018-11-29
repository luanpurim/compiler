package semantic;

public enum MsilCommand {

    SUM("sum"),
    SUB("sub"),
    DIV("div"),
    MUL("mul"),
    PUSH_NUMBER("ldc.r8 %s"),
    PUSH_LOGICAL("ldc.i4.%s"),
    READ_LINE("call string [mscorlib]System.Console::ReadLine()");

    MsilCommand(String code) {
        this.code = code;
    }

    private String code;

    public String get(Object... params) {
        return String.format(code);
    }
}
