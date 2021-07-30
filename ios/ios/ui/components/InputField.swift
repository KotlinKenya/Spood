import SwiftUI

struct InputField_Previews: PreviewProvider {
    
    static var previews: some View {
        InputField(text: "", hint: "Hint", label: "Label", type: .name)
    }
}

struct InputField: View {
    var text: String = ""
    var error: String? = nil
    var hint: String = ""
    var label: String = ""
    var type : UITextContentType = .name
    var onChange : (String) -> Void = {s in }
    
    @State private var location: String = ""
    
    var body: some View {
        VStack (alignment: .leading){
            Text(label)
                .font(.callout)
                .bold()
            
            TextField(hint, text: Binding<String> (get: { text}, set:{ onChange($0) }))
                .textFieldStyle(PlainTextFieldStyle())
                .padding()
                .overlay(RoundedRectangle(cornerRadius: 5).stroke(Color("lightGrey")))
            
            if error != nil{
                Text(error ?? "")
                    .font(.callout)
                    .foregroundColor(.red)
            }
        }
    }
}


