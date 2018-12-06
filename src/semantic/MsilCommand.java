package semantic;

public enum MsilCommand {

    ADD("add"),
    SUB("sub"),
    DIV("div"),
    MUL("mul"),
    AND("and"),
    OR("or"),
    PUSH_NUMBER("ldc.r8 %s"),
    PUSH_INTEGER("ldc.i8 %s"),
    PUSH_LITERAL("ldstr \"%s\""),
    PUSH_LOGICAL("ldc.i4.%s"),
    CONVERT_TO_NUMBER("conv.r8"),
    XOR("xor"),
    GREATER_THAN("cgt"),
    READ_VAR("ldloc %s"),
    LESS_THAN("clt"),
    EQUALS("ceq"),
    LOCALS(".locals(%s %s)"),
    SAVE_VAR("stloc %s"),
    ADD_LABEL("%s:"),
    JUMP_TRUE("brtrue %s"),
    JUMP_FALSE("brfalse %s"),
    JUMP("br %s"),
    READ_LINE("call string [mscorlib]System.Console::ReadLine()"),
    PARSE_STRING("call %s [mscorlib]System.%s::Parse(string)"),
    WRITE_LINE("call void [mscorlib] System.Console:Write(%s)"),
    PROGRAM_TAIL("ret\n"
		+ "}\n"
		+ "}"),
    PROGRAM_HEAD(".assembly extern mscorlib {}\n"
    			+".assembly _codigo_objeto{}\n"
    			+".module _codigo_objeto.exe\n"
    			+"\n"
    			+".class public _UNICA{\n"
    			+".method static public void _PRINCIPAL() {\n"
    			+ ".entrypoint\n");

    MsilCommand(String code) {
        this.code = code;
    }

    private String code;

    public String get(Object... params) {
        return String.format(code, params);
    }
}
