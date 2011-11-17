.text
	.global _main

_main:
	pushl %ebp
	movl %esp, %ebp
	movl $1, %edi
	pushl %edi	
	call decl
	ret

decl:
	pushl %ebp
	movl %esp, %ebp
	movl 8(%ebp), %eax
	ret

.data

