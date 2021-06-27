import Foundation

class SignUpViewModel: ObservableObject {
    
    @Published var fullName : String = ""
    @Published var phoneNumber : String = ""
    @Published var error : String = ""

    func signUp() -> Void {
        self.error = fullName 
    }
}
