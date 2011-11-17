.text
	.global _main

_main:
	pushl %ebp
	movl %esp, %ebp
	call decl
	ret

.data

