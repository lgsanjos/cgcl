.text
	.global _main
	.global _printf

_main:
	pushl %ebp
	movl %esp, %ebp

	movl $10, %edi

_loop:
	pushl %edi
	call my_printf
	addl $4, %esp
	
	decl %edi
	test %edi, %edi
	jnz _loop
	
	movl %ebp, %esp
	popl %ebp
	ret

my_printf:
	pushl %ebp
	movl %esp, %ebp
	
	movl 8(%ebp), %eax
	
	pushl $STR
	pushl %eax
	pushl $FMT
	call _printf
	addl $12, %esp
	
	movl %ebp, %esp
	popl %ebp
	ret
	
.data
	FMT: .ascii "teste %d %s\n\0"
	STR: .ascii "string\0"
	