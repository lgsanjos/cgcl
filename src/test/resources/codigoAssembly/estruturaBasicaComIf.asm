.text
	.global _main

_main:
	pushl %ebp
	movl %esp, %ebp
	ret
	
	mov %eax, a
    cmp %eax, b
    mov %eax, 1
    mov result, %eax	    
.data