    //DialogPermiso
   public static String showPasswordDialog(final Widget widget, final String title, final String correct_password)
    {
       
        try {
                       
            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);
            final CompletableFuture<String> done = new CompletableFuture<>();
           
            tk.execute(()->
                {
                    final PasswordDialog dialog = new PasswordDialog(title, correct_password);
                    DialogHelper.positionDialog(dialog, node, -100, -50);
                    dialog.initOwner(node.getScene().getWindow());
                    final Optional<String> result = dialog.showAndWait();
                    done.complete(result.orElse(null));
                });
            
            try {
                return done.get();

            } catch (Exception ex) {
                logger.info(ex.getMessage());
            }
        
            return null;
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return null;
        
    }
