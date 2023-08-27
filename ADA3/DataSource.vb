'https://learn.microsoft.com/es-es/dotnet/visual-basic/programming-guide/language-features/declared-elements/declared-element-names#rules
'https://learn.microsoft.com/es-es/dotnet/visual-basic/programming-guide/program-structure/naming-conventions
'https://learn.microsoft.com/es-es/dotnet/visual-basic/programming-guide/concepts/object-oriented-programming#classes-and-objects
'https://learn.microsoft.com/en-us/dotnet/api/system.io.fileinfo?view=net-7.0
'https://www.aprenderaprogramar.es/index.php?option=com_content&view=article&id=257:select-case-visual-basic-switch-segun-caso-hacer-ejemplos-y-ejercicios-resueltos-con-to-is-cu00325a

'https://learn.microsoft.com/es-mx/dotnet/fundamentals/code-analysis/style-rules/naming-rules
'https://learn.microsoft.com/es-es/dotnet/visual-basic/language-reference/statements/dim-statement

'los métodos públicos usan pascal case
'ttodos loc campos constantes no públicos son s_camelCase. 

    Public Sub LoadData()
        If Not dataFile.Exists Then

        Else
            Console.WriteLine("Existe")
            Dim input As New StreamReader(dataFile.FullName)
            Dim numAccounts As Integer
            Dim accountType As Char

            Dim numCustomers As Integer = Convert.ToInt32(input.ReadLine())

            For i As Integer = 0 To numCustomers - 1
                Dim firstName As String = input.ReadLine()
                Dim lastName As String = input.ReadLine()
                bank.AddCustomer(firstName, lastName, i)
                Dim customer As Customer = bank.GetCustomer(i)
                numAccounts = Convert.ToInt32(input.ReadLine())
                Console.WriteLine(numCustomers)

                While numAccounts > 0
                    accountType = Convert.ToChar(input.ReadLine())
                    Dim initBalance As Single = Convert.ToSingle(input.ReadLine())

                    Select Case accountType
                        Case "S"c
                            Dim interestRate As Single = Convert.ToSingle(input.ReadLine())
                            customer.AddAccount(New SavingAccount(initBalance, interestRate))
                            Exit Select
                        Case "C"c
                            Dim overdraftProtection As Single = Convert.ToSingle(input.ReadLine())
                            customer.AddAccount(New CheckingAccount(initBalance, overdraftProtection))
                            Exit Select
                        Case Else
                            Exit Select
                    End Select
                    numAccounts -= 1
                End While
            Next

        End If
    End Sub